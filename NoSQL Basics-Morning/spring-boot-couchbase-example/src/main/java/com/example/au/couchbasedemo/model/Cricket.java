package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Cricket {
	 	@Id
	    String id;
	    
	    @NotNull
	    @Field
	    String name;
	    
	    @NotNull
	    @Field
	    float average;
	    
	    @Field
	    int runs;
	    
	    @Field
	    int wickets;
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public float getAverage() {
			return average;
		}

		public void setAverage(float average) {
			this.average = average;
		}
		
		public int getRuns() {
			return runs;
		}

		public void setRuns(int runs) {
			this.runs = runs;
		}
		
		public int getWickets() {
			return wickets;
		}

		public void setWickets(int wickets) {
			this.wickets = wickets;
		}
		
		public String getId(String id) {
			return id;
		}
		
		public void setId(String id)
		{
			this.id = id;
		}
		
		public Cricket(String id, String name, float average, int runs, int wickets) {
			this.id = id;
			this.name = name;
			this.average = average;
			this.runs = runs;
			this.wickets = wickets;
		}
}
