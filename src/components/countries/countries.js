import React from "react";

const countries = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                            <tr>
                                <td scope={"col"}>Name</td>
                                <td scope={"col"}>Continent</td>
                            </tr>
                        </thead>
                        <tbody>
                            {props.countries.map((term) =>{
                                return (
                                    <tr>
                                        <td>{term.name}</td>
                                        <td>{term.continent}</td>
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
export default countries;