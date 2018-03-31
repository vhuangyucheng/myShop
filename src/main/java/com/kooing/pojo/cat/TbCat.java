package com.kooing.pojo.cat;

public class TbCat {
    private Long catId;

    private String uuid;

    private Integer storeId;

    private Integer memberId;

    private String catSn;

    private Double catAmout;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getCatSn() {
        return catSn;
    }

    public void setCatSn(String catSn) {
        this.catSn = catSn == null ? null : catSn.trim();
    }

    public Double getCatAmout() {
        return catAmout;
    }

    public void setCatAmout(Double catAmout) {
        this.catAmout = catAmout;
    }
}