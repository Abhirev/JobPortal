package com.abhi.jobportal;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abhi.jobportal.model.Job;
import com.abhi.jobportal.model.JobApplication;
import com.abhi.jobportal.model.User;
import com.abhi.jobportal.service.MyUserDetailsService;
import com.abhi.jobportal.service.UserService;
import com.abhi.jobportal.service.jobApplService;
import com.abhi.jobportal.service.jobService;

@CrossOrigin(origins = "https://jobportal-frontend-chi.vercel.app/", allowCredentials = "true")
@RestController
public class HomeController {
	
	@Autowired
	private jobService service;
	
	@Autowired
	private jobApplService appservice;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")  // Ensure GET is mapped
    public String home() {
        return "Welcome to the Job Portal!";
    }
    
    @GetMapping("/")  // Also allow GET for root
    public String index() {
        return "This is the Home Page!";
    }
	
	@GetMapping("/hello")
	public String greet() {
		return "Hello Utkarsh";
	}
	
	@GetMapping("/jobs")
	public List<Job> getAllJob(){	
		return service.getJobs();
	}
	
	//load dummy data
	@GetMapping("/load")
	public String load() {
		service.load();
		return "Success";
	}
	
	@PostMapping("/add")
	public Job addJob(@RequestBody Job job){
		return service.addJob(job);
	}

	@GetMapping("/job/{postId}")
	public Job getJobById(@PathVariable int postId ) {
		return service.getJob(postId);
	}
	
	@GetMapping("/jobs/{query}")
	public List<Job> searchJob(@PathVariable String query){
		return service.searchJob(query);
	}
	

    @GetMapping("/userRole")
    public ResponseEntity<Map<String, String>> getUserRole(Authentication authentication) {
        if (authentication != null) {
            String username = authentication.getName();  // Get the logged-in username
            String role = authentication.getAuthorities().iterator().next().getAuthority();  // Get role

            Map<String, String> response = new HashMap<>();
            response.put("username", username);
            response.put("role", role);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.userRegister(user);
	}
	
	@PostMapping("/jobs/apply")
	public ResponseEntity<String> apply(
	    @RequestParam("jobId") Long jobId,
	    @RequestParam("userId") Long userId,
	    @RequestParam("additionalNotes") String additionalNotes,
	    @RequestParam("resume") MultipartFile resume
	) {
	    JobApplication application = new JobApplication();
	    application.setJobId(jobId);
	    application.setUserId(userId);
	    application.setAdditionalNotes(additionalNotes);
	    
	    try {
	        application.setResume(resume.getBytes());
	    } catch (IOException e) {
	        return ResponseEntity.badRequest().body("Failed to upload resume");
	    }
	    
	    appservice.add(application);
	    return ResponseEntity.ok("Application Successful!!");
	}
	
	@GetMapping("/debug")
	public String debugUser() {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    return "User: " + auth.getName() + " | Roles: " + auth.getAuthorities();
	}
	
}
