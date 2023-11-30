import React, { useEffect, useState } from 'react'
import { getAllDepartments } from '../services/DepartmentService';
import { Link , useNavigate } from 'react-router-dom';
import { Button } from 'bootstrap';

const ListDepartmentComponent = () => {
  
  const[departments, setDepartments]=useState([]);
  const navigator= useNavigate();

  useEffect(()=>{
    getAllDepartments().then((response)=>{
      console.log(response.data);
      setDepartments(response.data);
    }).catch((err)=> {
      console.error(err)
    });
  },[])

  function updateDepartment(id){
    navigator(`/eit-department/${id}`);
  }

  return (
    <div className='container'>
      <h2 className='text-center'>List of Departments</h2>
      <Link to='/add-department' className='btn btn-primary mb-2'>Add Department</Link>
      <table className='table table-striped table-bordered'>
        <thead>
            <tr>
                <th>Department ID</th>
                <th>Department Name</th>
                <th>Department Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            {
                departments.map(department=>
                    <tr key={department.id}>
                        <td>{department.id}</td>
                        <td>{department.departmentName}</td>
                        <td>{department.departmentDescription}</td>
                        <td><button className='btn btn-info' onClick={()=>updateDepartment(department.id)}>Update</button></td>
                    </tr>
                )
            }
        </tbody>
      </table>
    </div>
  )
}

export default ListDepartmentComponent
