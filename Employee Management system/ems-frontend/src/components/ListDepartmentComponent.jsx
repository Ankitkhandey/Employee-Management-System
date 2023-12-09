import React, { useEffect, useState } from 'react'
import { getAllDepartments,deleteDepartment } from '../services/DepartmentService';
import { Link , useNavigate } from 'react-router-dom';
import { Button } from 'bootstrap';

const ListDepartmentComponent = () => {
  
  const[departments, setDepartments]=useState([]);
  const navigator= useNavigate();

  useEffect(()=>{
    listDepartments();
  },[])

  function listDepartments(){
    getAllDepartments().then((response)=>{
      console.log(response.data);
      setDepartments(response.data);
    }).catch((err)=> {
      console.error(err)
    });
  }

  function removeDepartment(id){
    deleteDepartment(id).then((response)=>{
      console.log(response.data);
      listDepartments();
    }).catch((errorMessage)=>{
      console.error(errorMessage);
    });
  }

  function updateDepartment(id){
    navigator(`/edit-department/${id}`);
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
                        <td>
                        <button className='btn btn-info' onClick={()=>updateDepartment(department.id)}>Update</button>
                        <button className='btn btn-danger' onClick={()=>removeDepartment(department.id)} style={{marginLeft:"10px"}}>Delete</button>
                        </td>
                    </tr>
                )
            }
        </tbody>
      </table>
    </div>
  )
}

export default ListDepartmentComponent
