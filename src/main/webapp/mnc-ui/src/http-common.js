import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:8764/project",
    headers: {
        "Content-type": "application/json"
    }
});