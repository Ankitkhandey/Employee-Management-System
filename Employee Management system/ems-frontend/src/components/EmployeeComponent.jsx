import { useState } from "react"
import { addEmployee } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";

const EmployeeComponent = () => {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email , setEmail] = useState('');
    const navigator = useNavigate();

    const [errors, SetErrors] = useState({
        firstName : '',
        lastName : '',
        email : ''
    });

    function saveEmployee(event){
        event.preventDefault();
        if (validateForm()){
        const employee={firstName, lastName,email}
        addEmployee(employee).then((response)=>{
            console.log(response);
            navigator('/employees')
        });
      }
    }

    function validateForm (){
        let valid = true; 
        const newError = {...errors};

        if (firstName.trim()){
            newError.firstName="";
        }else {
            newError.firstName="First Name is required";
            valid= false;
        }

        if (lastName.trim()){
            newError.lastName="";
        }else {
            newError.lastName="Last Name is required";
            valid= false;
        }

        if (email.trim()){
            newError.email="";
        }else {
            newError.email="Email is required";
            valid= false;
        }        

        SetErrors(newError);
        return valid;
    }
  return (
    <div className= 'container'>
    <br></br> <br></br>
        <div className="row">
            <div className="card col-md-6  offset-md-3">
            <h2 className="text-center">Add Employee</h2>

                <div className="card-body">
                    <div className="form-gorup mb-2">
                    <label>First Name</label>
                    <input
                    type="text"
                    placeholder="Enter Employee's First Name"
                    name= "firstName"
                    value={firstName}
                    className={`form-control ${errors.firstName? 'is-invalid': ''}`}
                    onChange={(event)=> setFirstName(event.target.value)}
                    >
                    </input>
                    {errors.firstName && <div className="invalid-feedback">{errors.firstName} </div> }
                    </div>

                    <div className="form-gorup mb-2">
                    <label>Last Name</label>
                    <input
                    type="text"
                    placeholder="Enter Employee's Last Name"
                    name= "lastName"
                    value={lastName}
                    className={`form-control ${errors.lastName? 'is-invalid': ''}`}
                    onChange={(event)=> setLastName(event.target.value)}
                    >
                    </input>
                    {errors.lastName && <div className="invalid-feedback"> {errors.lastName} </div> }
                    </div>

                    <div className="form-gorup mb-2">
                    <label>Email id</label>
                    <input
                    type="text"
                    placeholder="Enter Employee's email id"
                    name= "email"
                    value={email}
                    className={`form-control ${errors.firstName? 'is-invalid': '' }`}
                    onChange={(event)=> setEmail(event.target.value)}
                    >
                    </input>
                    {errors.email && <div className="invalid-feedback"> {errors.email} </div> }
                    </div>

                    <button className="btn btn-success" onClick={saveEmployee} >Submit</button>
                </div>
            </div>
        </div>
      
    </div>
  )
}

export default EmployeeComponent
