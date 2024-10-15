import axios from 'axios'

const API_URL = 'http://68.183.107.41:8080/api/cuentas'

class CuentaService {
  async crearCuenta(cuenta) {
    try {
      const response = await axios.post(`${API_URL}/registrar`, cuenta)
      return response.data
    } catch (error) {
      throw error.response ? error.response.data : 'Error de conexión'
    }
  }

  async obtenerCuentas() {
    try {
      const response = await axios.get(API_URL)
      return response.data
    } catch (error) {
      throw error.response ? error.response.data : 'Error de conexión'
    }
  }

  async obtenerCuentaPorNumero(numeroCuenta) {
    try {
      const response = await axios.get(`${API_URL}/${numeroCuenta}`)
      return response.data
    } catch (error) {
      throw error.response ? error.response.data : 'Error de conexión'
    }
  }

  async depositar(numeroCuenta, monto) {
    try {
      const response = await axios.post(`${API_URL}/${numeroCuenta}/depositar`, { monto })
      return response.data
    } catch (error) {
      throw error.response ? error.response.data : 'Error de conexión'
    }
  }

  async retirar(numeroCuenta, monto) {
    try {
      const response = await axios.post(`${API_URL}/${numeroCuenta}/retirar`, { monto })
      return response.data
    } catch (error) {
      throw error.response ? error.response.data : 'Error de conexión'
    }
  }
}

export default new CuentaService()
