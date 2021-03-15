package com.springboot.demo.util.Sig;

public class FileDownDto {
    /**
     * 订单id
     */
    @Signature
    private Long tradeId;
    /**
     * 文件类型编码
     */
    @Signature
    private String attrCode;

    private String attrValue;

    private String attrDesc;

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public String getAttrCode() {
        return attrCode;
    }

    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

}

