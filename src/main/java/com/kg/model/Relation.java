package com.kg.model;

import java.util.HashMap;
import java.util.Map;

public class Relation {

    private Map<Long,Double> weights=new HashMap<Long,Double>();

    private Long jobId;

    public Map<Long, Double> getWeights() {
        return weights;
    }

    public void InsertWeights(Long Id,Double weight) {
        this.weights.put(Id,weight);
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }


}
