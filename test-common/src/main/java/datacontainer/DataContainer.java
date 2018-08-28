package datacontainer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataContainer {
    private Map<String, Object> storedData = new HashMap<>();

    @Bean
    public DataContainer getDataContainer() {
        return new DataContainer();
    }

    public void setDataInTestStorage(String key, Object value) {
        storedData.put(key, value);
    }

    public Object getValueFromTestStorage(String key) {
        return storedData.get(key);
    }
}
