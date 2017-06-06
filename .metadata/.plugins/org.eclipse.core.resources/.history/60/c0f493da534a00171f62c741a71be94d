package com.jpro.studentsmeetcontrollerrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpro.studentsmeetbackend.dao.JobDAO;
import com.jpro.studentsmeetbackend.model.Job;

@RestController
public class JobController {
	
private static final Logger log=LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	private Job job;
	
	@Autowired
	private JobDAO jobDAO;
	
	@PostMapping("/createjob")
	public String createjob(@RequestBody Job newjob){
		log.debug("Creating job");
		boolean valid=jobDAO.createJob(newjob);
		if(valid){
			log.debug("job created");
			return "Success";
		}
		else{
			log.debug("job not created");
			return "Error";
		}
	}

	@GetMapping("/removejob/{jobID}")
	public String removejob(@PathVariable("jobID") long jobID){
		log.debug("Creating job");
		job=jobDAO.getJobById(jobID);
		boolean valid=jobDAO.removeJob(job);
		if(valid){
			log.debug("job removed");
			return "Success";
		}
		else{
			log.debug("job not removed");
			return "Error";
		}
	}

	@PostMapping("/updatejob")
	public String updatejob(@RequestBody Job updatejob){
		log.debug("Creating job");
		boolean valid=jobDAO.updateJob(updatejob);
		if(valid){
			log.debug("job updated");
			return "Success";
		}
		else{
			log.debug("job not updated");
			return "Error";
		}
	}
	
	@GetMapping("/getjobById/{jobID}")
	public ResponseEntity<Job> getjobById(@PathVariable("jobID") long jobID){
		log.debug("Getting job with id:"+jobID);
		job=jobDAO.getJobById(jobID);
		if(job!=null){
			log.debug("job acquired");
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else{
			log.debug("job not acquired");
			return null;
		}
	}
	
	@GetMapping("/getAlljob")
	public ResponseEntity<List<Job>> getAlljob(){
		log.debug("Getting all job");
		return new ResponseEntity<List<Job>>(jobDAO.getAllJobs(),HttpStatus.OK);
	}


}
