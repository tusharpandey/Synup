
package com.app.synuptest.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class VariantGroup {

    @Expose
    @SerializedName("group_id")
    private String groupId;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("variations")
    private List<Variation> variations = null;

    private HashMap<String, String> excludedItem = new HashMap<>();

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

    public void setChecked(String variationId, Pizza pizza) {
        if (variations != null) {
            for (Variation variation : variations) {
                variation.setChecked(false);
                if (variation.getId().equals(variationId)) {
                    variation.setChecked(true);
                }
            }
        }
    }
}
