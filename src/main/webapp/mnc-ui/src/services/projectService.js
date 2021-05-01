import http from "../http-common";

class ProjectService {
    getAll() {
        return http.get("/list");
    }

    get(id) {
        return http.get(`/view/${id}`);
    }


    add(data) {
        return http.post("/add", data);
    }

    //
    update(data) {
        return http.put("/update", data);
    }

    delete(id) {
        return http.delete(`/delete/${id}`);
    }
    //
    // deleteAll() {
    //     return http.delete(`/tutorials`);
    // }
    //
    // findByTitle(title) {
    //     return http.get(`/tutorials?title=${title}`);
    // }
}

export default new ProjectService();