/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model.exception;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Binh
 */
public class LowerLimitExceedsUpperException extends Exception {
    
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal lowerLimit;
    private BigDecimal upperLimit;

    public LowerLimitExceedsUpperException(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LowerLimitExceedsUpperException(BigDecimal lowerLimit, BigDecimal upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public BigDecimal getUpperLimit() {
        return upperLimit;
    }
    
    
    

    public void sendMessageForAmount() {
        System.out.println("Your lower limit is higher than the upper limit");
    }

    public void sendMessageForDate() {
        System.out.println("Your start date is after your end date");
    }
;

}
