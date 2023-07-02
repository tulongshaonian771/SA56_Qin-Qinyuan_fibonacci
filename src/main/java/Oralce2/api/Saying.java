package Oralce2.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class Saying {
    private List<Double> fibonacci;

    private List<Double> sorted;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(List<Double> fibonacci, List<Double> sorted) {
        this.fibonacci = fibonacci;
        this.sorted = sorted;
    }
    @JsonProperty
    public List<Double> getFibonacci() {
        return fibonacci;
    }
    @JsonProperty
    public void setFibonacci(List<Double> fibonacci) {
        this.fibonacci = fibonacci;
    }
    @JsonProperty
    public List<Double> getSorted() {
        return sorted;
    }
    @JsonProperty
    public void setSorted(List<Double> sorted) {
        this.sorted = sorted;
    }
}