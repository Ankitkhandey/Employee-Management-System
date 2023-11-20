import React, { useState } from 'react'

const ListDepartmentComponent = () => {
  const dummyData=[
    {
        "id":"1",
        "departmentName": "R&D",
        "departmentDescription":"Research and development"
    },
    {
        "id":"2",
        "departmentName": "IT",
        "departmentDescription":"Information Technology"
    },
    {
        "id":"3",
        "departmentName": "Finance",
        "departmentDescription":"manages fianances"        
    }
  ];
  
  const[departments, setDepartments]=useState(dummyData);

  return (
    <div className='container'>
      <h2 className='text-center'>List of Departments</h2>
      <table className='table table-striped table-bordered'>
        <thead>
            <tr>
                <th>Department ID</th>
                <th>Department Name</th>
                <th>Department Description</th>
            </tr>
        </thead>
        <tbody>
            {
                departments.map(department=>
                    <tr key={department.id}>
                        <td>{department.id}</td>
                        <td>{department.departmentName}</td>
                        <td>{department.departmentDescription}</td>
                    </tr>
                )
            }
        </tbody>
      </table>
    </div>
  )
}

export default ListDepartmentComponent
