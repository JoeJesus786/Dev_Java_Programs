package com.hackerrank.sample.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hackerrank.sample.dto.FilteredProducts;
import com.hackerrank.sample.dto.SortedProducts;

@RestController
public class SampleController {

	

final String uri = "https://jsonmock.hackerrank.com/api/inventory";

    private JSONArray fetchAllPages() {
        RestTemplate restTemplate = new RestTemplate();
        JSONArray allData = new JSONArray();
        int page = 1;
        int totalPages = 1;

        do {
            String pagedUri = uri + "?page=" + page;
            String result = restTemplate.getForObject(pagedUri, String.class);
            JSONObject root = new JSONObject(result);
            JSONArray pageData = root.getJSONArray("data");
            totalPages = root.getInt("total_pages");

            for (int i = 0; i < pageData.length(); i++) {
                allData.put(pageData.getJSONObject(i));
            }

            page++;
        } while (page <= totalPages);

        return allData;
    }
		
		@CrossOrigin
		@GetMapping("/filter/price/{initial_price}/{final_price}")  
		private ResponseEntity< ArrayList<FilteredProducts> > filtered_books(@PathVariable("initial_price") int init_price , @PathVariable("final_price") int final_price)   
		{  


	        if (init_price > final_price) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        try {
	            JSONArray data = fetchAllPages();
	            ArrayList<FilteredProducts> books = new ArrayList<>();

	            for (int i = 0; i < data.length(); i++) {
	                JSONObject obj = data.getJSONObject(i);
	                int price = obj.getInt("price");
	                if (price >= init_price && price <= final_price) {
	                    books.add(new FilteredProducts(obj.getString("barCode")));
	                }
	            }

	            return new ResponseEntity<ArrayList<FilteredProducts>>(books, HttpStatus.OK);			   
			    
			}catch(Exception E)
				{
	   	System.out.println("Error encountered : "+E.getMessage());
	    return new ResponseEntity<ArrayList<FilteredProducts>>(HttpStatus.NOT_FOUND);
				}
			
		}  
		
		
		@CrossOrigin
		@GetMapping("/sort/price")  
		private ResponseEntity<SortedProducts[]> sorted_books()   
		{  
			
			try {

	            JSONArray data = fetchAllPages();
	            ArrayList<JSONObject> productList = new ArrayList<>();

	            for (int i = 0; i < data.length(); i++) {
	                productList.add(data.getJSONObject(i));
	            }

	            Collections.sort(productList, Comparator.comparingInt(p -> p.getInt("price")));

	            SortedProducts[] sorted = new SortedProducts[productList.size()];
	            for (int i = 0; i < productList.size(); i++) {
	                sorted[i] = new SortedProducts(productList.get(i).getString("barCode"));
	            }

	            return new ResponseEntity<>(sorted, HttpStatus.OK);

			    
			}catch(Exception E)
				{
	   	System.out.println("Error encountered : "+E.getMessage());
	    return new ResponseEntity<SortedProducts[]>(HttpStatus.NOT_FOUND);
				}
			
		}  
		
		
	
}
