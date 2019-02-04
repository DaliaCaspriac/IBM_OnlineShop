package com.ibm.internship.onlineshop.facade.dtos;

public class ProductReviewDTO {

    private String comment;
    private int starts;

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
}
