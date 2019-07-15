
package com.app.synuptest.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Variants {

    @Expose
    @SerializedName("variant_groups")
    private List<VariantGroup> variantGroups = null;

    @Expose
    @SerializedName("exclude_list")
    private List<List<ExcludeList>> excludeList = null;

    public List<VariantGroup> getVariantGroups() {
        return variantGroups;
    }

    public void setVariantGroups(List<VariantGroup> variantGroups) {
        this.variantGroups = variantGroups;
    }

    public List<List<ExcludeList>> getExcludeList() {
        return excludeList;
    }

    public void setExcludeList(List<List<ExcludeList>> excludeList) {
        this.excludeList = excludeList;
    }

}
