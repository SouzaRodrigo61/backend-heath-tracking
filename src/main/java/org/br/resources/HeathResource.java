package org.br.resources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.br.models.Health;
import org.br.models.PersonId;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.tags.Tags;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Path("/person-health")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tags(value = @Tag(name = "Health"))
public class HeathResource implements PanacheRepository<Health> {

    private static String exceptionText = "Person with id of ";
    private static String doesntExist = " does not exist.";

    @GET
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public List<Health> list() {
        return Health.listAll();
    }

    @POST
    @Transactional
    public Response create(Health helth) {

        helth.persist();
        return Response.ok(helth).status(201).build();
    }

    @PUT
    @Transactional
    public Health update(Health helth) {
        if (helth.healthId == null) {
            throw new WebApplicationException("Fruit Name was not set on request.", 422);
        }

        Health entity = Health.findById(helth.healthId);

        if (entity == null) {
            throw new WebApplicationException(exceptionText + helth.healthId + doesntExist, 404);
        }

        entity.childhoodDiseases = helth.childhoodDiseases;
        entity.congenitaldiseases = helth.congenitaldiseases;
        entity.healthTreatment = helth.healthTreatment;
        entity.heartDiseases = helth.heartDiseases;
        entity.height = helth.height;
        entity.kidneyDiseases = helth.kidneyDiseases;
        entity.neurologicalDiseases = helth.neurologicalDiseases;
        entity.otherComorbidities = helth.otherComorbidities;
        entity.respiratoryDiseases = helth.respiratoryDiseases;
        entity.weight = helth.weight;

        return entity;
    }

    @DELETE
    @Transactional
    public Response delete(PersonId id) {
        Health entity = Health.findById(id);
        if (entity == null) {
            throw new WebApplicationException(exceptionText + id + doesntExist, 404);
        }
        entity.delete();
        return Response.status(204).build();
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

        @Override
        public Response toResponse(Exception exception) {
            int code = 500;
            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }
            return Response.status(code)
                    .entity(Json.createObjectBuilder().add("error", exception.getMessage()).add("code", code).build())
                    .build();
        }

    }
}