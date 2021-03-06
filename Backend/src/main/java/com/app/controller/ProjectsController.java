package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.custom_excs.ProjectsNotFoundException;
import com.app.dao.IProjectsDao;
import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.Issues;
import com.app.pojos.Projects;


@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
@Validated //To enable :  validation err handling on request params or path variables
public class ProjectsController {
	// dependency: repository(DAO layer i/f)
	@Autowired
	private IProjectsDao projectsdao;

	public ProjectsController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	@GetMapping
	public ResponseEntity<?> getAllProjectsDetails() {
		System.out.println("in list all projects");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Projects>projects = projectsdao.findAll();
		
			// empty product list : set sts code : HTTP 204 (no contents)
			//return new ResponseEntity<>(projects, HttpStatus.OK);
			//return ResponseEntity.ok(projects);//sts code : 200 , body : list of projects
		return new ResponseEntity<>(new ResponseDTO("success","List of all projects", projects),HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<?> getAllProjectsIds() {
		System.out.println("in list all projects");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Integer>projects = projectsdao.getProjectId();
		
			// empty product list : set sts code : HTTP 204 (no contents)
			//return new ResponseEntity<>(projects, HttpStatus.OK);
			//return ResponseEntity.ok(projects);//sts code : 200 , body : list of projects
		return new ResponseEntity<>(new ResponseDTO("success","List of all projects", projects),HttpStatus.OK);
	}

//	@GetMapping("/{projectId}")
//	public ResponseEntity<?> getProjectDetailsById(@PathVariable Integer projectId) {
//		System.out.println("in get proj details " + projectId);
//		// invoke service method
//		Optional<Projects> optional = projectsdao.findByProjectId(projectId);
//		// valid name : HTTP 200 , marshalled product details
//		if (optional.isPresent())
//			//return new ResponseEntity<>(optional.get(), HttpStatus.OK);
////		    return  ResponseEntity.ok(optional.get());
////		 // invalid id
////			ErrorResponse resp = new ErrorResponse("Issue Id Invalid", "");
////			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
//			 return new ResponseEntity<>(new ResponseDTO("success","details found",optional.get()),HttpStatus.OK);
//		 // invalid id
//			ErrorResponse resp = new ErrorResponse("Project Name Invalid", "");
//			return new ResponseEntity<>(new ResponseDTO("error","details not found",null),HttpStatus.OK);
//	}

	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectsDetails(@PathVariable Integer projectId) {
		System.out.println("in get proj details " + projectId);
		// invoke service method
		Optional<Projects> optional = projectsdao.findByProjectId(projectId);
		// valid name : HTTP 200 , marshalled product details
		if (optional.isPresent())
			//return new ResponseEntity<>(optional.get(), HttpStatus.OK);
//		    return  ResponseEntity.ok(optional.get());
//		 // invalid id
//			ErrorResponse resp = new ErrorResponse("Issue Id Invalid", "");
//			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
			 return new ResponseEntity<>(new ResponseDTO("success","details found",optional.get()),HttpStatus.OK);
		 // invalid id
			ErrorResponse resp = new ErrorResponse("Project Name Invalid", "");
			return new ResponseEntity<>(new ResponseDTO("error","details not found",null),HttpStatus.OK);
	}
	// get prduct details by its name : supplied by clnt using path var
//	@GetMapping("/{projectName}")
//	public ResponseEntity<?> getProjectDetails(@PathVariable String projectName) {
//		System.out.println("in get proj details " + projectName);
//		// invoke service method
//		Optional<Projects> optional = projectsdao.findByProjectName(projectName);
//		// valid name : HTTP 200 , marshalled product details
//		if (optional.isPresent())
//			//return new ResponseEntity<>(optional.get(), HttpStatus.OK);
//		    return new ResponseEntity<>(new ResponseDTO("success","details found",optional.get()),HttpStatus.OK);
//		 // invalid id
//			ErrorResponse resp = new ErrorResponse("Project Id Invalid", "");
//			return new ResponseEntity<>(new ResponseDTO("error","details not found",null),HttpStatus.OK);
//	}

	// add new project details : Create : POST
	// @RequestBody : un marshalling (json ---> java obj)
	//plus validation rules will be invoked from the POJO.
	@PostMapping
	public ResponseEntity<?> addProjects(@RequestBody Projects p) {
		   System.out.println("in add projects " + p);
		   return new ResponseEntity<>(new ResponseDTO("success","project added successfully",projectsdao.save(p)),HttpStatus.CREATED);
			//return new ResponseEntity<>(projectsdao.save(p),HttpStatus.CREATED);
		}
	
	// update existing projects details : post / put
	// http://host:port/projects/15
	// req handling method to update existing projects
	@PutMapping("/{projectId}")
	public ResponseEntity<?> updateProjectDetails(@PathVariable int projectId, @RequestBody Projects p) {
		System.out.println("in update projects" + projectId + " " + p);
		// check if project exists
				Optional<Projects> optional = projectsdao.findByProjectId(projectId);
             		if (optional.isPresent()) 
					
             			{
             					// emp id valid : update the same
             					Projects existingProjects = optional.get();// DETACHED
             					System.out.println("existing emp " + existingProjects);
//             					existingProjects.setProjectName(p.getProjectName());
//             					existingProjects.setModifiedOn(p.getModifiedOn());
             					//existingProjects.setProjectId(p.getProjectId());
            					existingProjects.setProjectName(p.getProjectName());
            					existingProjects.setStartDate(p.getStartDate());
            					existingProjects.setTargetEndDate(p.getTargetEndDate());
            					existingProjects.setActualEndDate(p.getActualEndDate());
            					existingProjects.setCreatedOn(p.getCreatedOn());
            					existingProjects.setCreatedBy(p.getCreatedBy());
            					
            					existingProjects.setModifiedOn(p.getModifiedOn());
            					existingProjects.setModifiedBy(p.getModifiedBy());
             					// update detached POJO
             					return new ResponseEntity<>(new ResponseDTO("success","Project details updated succesfully",projectsdao.save(existingProjects)), HttpStatus.OK);
             					// save or update (insert: transient(value of ID : default
             					// or non default value BUT existing on DB -- update
             				} else
             					return new ResponseEntity<>(new ResponseDTO("error","details not found",null),HttpStatus.OK);

             			}

			
	
	//req handling method to delete existing project
	@DeleteMapping("/{pid}")
	public ResponseEntity<?> deleteProjectDetails(@PathVariable  int pid) {
		System.out.println("in delete emp " + pid);
		// check if emp exists
		Optional<Projects> optional = projectsdao.findByProjectId(pid);
		if (optional.isPresent()) {
			projectsdao.deleteById(pid);
			return new ResponseEntity<>(new ResponseDTO("success","Project record deleted with ID " ,+ pid), HttpStatus.OK);
		} else
			 throw new ProjectsNotFoundException("Project ID Invalid : record deletion failed");
		//	throw new RuntimeException("my own err mesg");

	}
	

}
