package com.project.rest.webservices.restfulwebservices.versioning;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public ResponseEntity<PersonV1> getFirstVersionOfPerson() {
        return new ResponseEntity<PersonV1>(new PersonV1("bob charlie"), HttpStatus.CREATED);
    }

    @GetMapping("/v2/person")
    public ResponseEntity<PersonV2> getSecondVersionOfPerson() {
        return new ResponseEntity<PersonV2>(new PersonV2("bob","charlie"), HttpStatus.CREATED);
    }
    @GetMapping(path = "/person",params = "version=1")
    public ResponseEntity<PersonV1> getFirstVersionOfPersonReqParam() {
        return new ResponseEntity<PersonV1>(new PersonV1("bob charlie"), HttpStatus.CREATED);
    }
    @GetMapping(path = "/person",params = "version=2")
    public ResponseEntity<PersonV2> getSecondVersionOfPersonReqParam() {
        return new ResponseEntity<PersonV2>(new PersonV2("bob","charlie"), HttpStatus.CREATED);
    }
    @GetMapping(path = "/person",headers = "version=1")
    public ResponseEntity<PersonV1> getFirstVersionOfPersonHeaderParam() {
        return new ResponseEntity<PersonV1>(new PersonV1("bob charlie"), HttpStatus.CREATED);
    }
    @GetMapping(path = "/person",headers = "version=2")
    public ResponseEntity<PersonV2> getSecondVersionOfPersonHeaderParam() {
        return new ResponseEntity<PersonV2>(new PersonV2("bob","charlie"), HttpStatus.CREATED);
    }

    @GetMapping(path = "/person",produces = "application/vnd.company.app-v1+json")
    public ResponseEntity<PersonV1> getFirstVersionOfPersonAcceptParam() {
        return new ResponseEntity<PersonV1>(new PersonV1("bob charlie"), HttpStatus.CREATED);
    }
    @GetMapping(path = "/person",produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<PersonV2> getSecondVersionOfPersonAcceptParam() {
        return new ResponseEntity<PersonV2>(new PersonV2("bob","charlie"), HttpStatus.CREATED);
    }
}
