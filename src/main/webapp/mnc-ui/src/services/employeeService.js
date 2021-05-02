import http from "../http-employee"

class EmployeeService{

    add(data) {
        return http.post("/signup", data);
    }

    getAll() {
        return http.get("/listEmployees");
    }
}

export default new EmployeeService();