

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

public class JSONSchemaUnitTest {

    @Test
    public void givenInvalidInput_whenValidating_thenInvalid() {

        JSONObject jsonSchema = new JSONObject(new JSONTokener(JSONSchemaUnitTest.class.getResourceAsStream("C:/Users/mridulshukla/Desktop/workspace/Excelt/src/test/resources/schema.json")));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(JSONSchemaUnitTest.class.getResourceAsStream("/info.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }

  
}
