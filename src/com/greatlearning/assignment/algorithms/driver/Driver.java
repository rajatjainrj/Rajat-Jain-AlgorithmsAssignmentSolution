package com.greatlearning.assignment.algorithms.driver;

import com.greatlearning.assignment.algorithms.service.StockersPriceComparatorService;

/**
 * @author rajatjain on - 29-12-2021
 * @project AlgorithmsAssignment
 */
public class Driver {

    public static void main(String[] args) {
        StockersPriceComparatorService service = new StockersPriceComparatorService();
        service.inputNoOfCompaniesAndTheirStockPrices();
        boolean showMenuOptions = true;
        while (showMenuOptions){
            int action = service.showMenuOptionsAndReturnSelection();
            if(action == 0){
                showMenuOptions = false;
            }
            service.performActions(action);
        }
    }

}
