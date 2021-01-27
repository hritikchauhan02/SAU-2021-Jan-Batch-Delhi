package com.student;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path(value = "student")
public class StudentController {

    StudentService service = new StudentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GET
    @Path("/{rollNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getStudentByRollNo(@PathParam("rollNo") int rollNo) {
        Student s = service.getStudentByRollNo(rollNo);

        if(s == null) {
            return "Student does not exist with given Roll No.";
        }
        return s;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Object addStudent(Student student) {
        return service.addStudent(student);
    }

    @PUT
    @Path("/{rollNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object updateStudent(@PathParam("rollNo") int rollNo, Student student)
    {
        return service.updateStudent(rollNo, student);
    }

    @DELETE
    @Path("/{rollNo}")
    public String deleteStudent(@PathParam("rollNo") int rollNo)
    {
        return service.deleteStudent(rollNo);
    }
}