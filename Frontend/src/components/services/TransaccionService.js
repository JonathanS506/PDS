import axios from 'axios'

const API_URL = 'http://localhost:8080/api/transacciones'

class TransaccionService {
  async registrarTransaccion(transaccion, idCliente, pinIngresado) {
    try {
      const response = await axios.post(`${API_URL}`, { ...transaccion, idCliente, pinIngresado })
      return response.data
    } catch (error) {
      throw error.response.data
    }
  }

  async obtenerTransacciones(idCliente) {
    try {
      const response = await axios.get(`${API_URL}/${idCliente}`)
      return response.data
    } catch (error) {
      throw error.response.data // Manejo de errores
    }
  }
}

export default new TransaccionService()
