package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.entity.UpdatePropertyEntity;
import cucumber.api.java.en.And;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.testng.Assert.assertEquals;

@ApplicationScoped
public class PropertyUpdateResourceSteps extends BaseSteps {

    private static final WebTarget modulePropertiesTarget = testSupportRestApiBaseTarget.path("/properties/module");

    @And("^I change \"(.*)\" value to \"(.*)\" on property update resource$")
    public void I_change_value_to_on_property_update_resource(String key, String value) throws Throwable {
        UpdatePropertyEntity updatePropertyEntity = new UpdatePropertyEntity();
        updatePropertyEntity.setKey(key);
        updatePropertyEntity.setValue(value);

        target = modulePropertiesTarget;
        response = target.request().post(Entity.entity(updatePropertyEntity, MediaType.APPLICATION_JSON));
        response.bufferEntity();

        assertEquals(response.getStatus(), 200);
    }
}
