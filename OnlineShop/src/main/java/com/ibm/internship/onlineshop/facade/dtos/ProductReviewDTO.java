package com.ibm.internship.onlineshop.facade.dtos;

public class ProductReviewDTO {

    private int reviewID;
    private String comment;
    private int starts;
    private int productCode;

    public ProductReviewDTO(int reviewID, String comment, int starts, int productCode) {
        this.reviewID = reviewID;
        this.comment = comment;
        this.starts = starts;
        this.productCode = productCode;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStarts() {
        return starts;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
}
