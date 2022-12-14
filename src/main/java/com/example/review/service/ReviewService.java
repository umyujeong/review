package com.example.review.service;

import com.example.review.dto.Review;
import com.example.review.dto.ReviewAvgResponse;
import com.example.review.dto.ReviewResponse;
import com.example.review.dao.ReviewDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewDao reviewDao;

    @Transactional
    public void save(Review review){
        reviewDao.save(review);
    }

    public List<ReviewResponse> findall(){
        List<ReviewResponse> all = reviewDao.findAll();
        return all;
    }
    public List<ReviewAvgResponse> findSizeAvg(){
        List<ReviewAvgResponse> all = reviewDao.findSizeAvg();
        System.out.println("service");
        for (ReviewAvgResponse reviewAvgResponse : all) {
            System.out.println(reviewAvgResponse.toString());
        }
        return all;
    }
}
