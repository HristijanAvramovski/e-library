import React from "react";

const authors = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <td scope={"col"}>Name</td>
                            <td scope={"col"}>Surname</td>
                            <td scope={"col"}>Country</td>
                        </tr>
                        </thead>
                        <tbody>
                        {props.authors.map((term) =>{
                            return (
                                <tr>
                                    <td>{term.name}</td>
                                    <td>{term.surname}</td>
                                    <td>{term.country.name}</td>
                                </tr>
                            )
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}
export default authors;
