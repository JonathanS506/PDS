import axios from 'axios';

const API_URL = 'http://localhost:8080/api/clientes/juridicos'; 

class ClienteService {
    async crearCliente(clienteJuridico) {
        try {
            const response = await axios.post(API_URL, clienteJuridico);
            return response.data;
        } catch (error) {
            throw error.response.data;
        }
    }

    async obtenerClientes() {
        try {
            const response = await axios.get(API_URL);
            return response.data;
        } catch (error) {
            throw error.response.data; 
        }
    }
}

export default new ClienteService();
