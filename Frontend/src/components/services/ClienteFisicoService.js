import axios from 'axios'

const API_URL = 'http://localhost:8080/api/clientes/fisicos'

class ClienteService {
  async crearCliente(clienteFisico) {
    try {
      const response = await axios.post(API_URL, {
        nombrePila: clienteFisico.nombrePila,
        primerApellido: clienteFisico.primerApellido,
        segundoApellido: clienteFisico.segundoApellido,
        identificacion: clienteFisico.identificacion,
        telefono: clienteFisico.telefono,
        correoElectronico: clienteFisico.correoElectronico,
        cantidadCuentas: clienteFisico.cantidadCuentas,
        fechaNacimiento: clienteFisico.fechaNacimiento
      })
      return response.data
    } catch (error) {
      throw error.response ? error.response.data : error
    }
  }

  async obtenerClientes() {
    try {
      const response = await axios.get(API_URL)
      return response.data
    } catch (error) {
      throw error.response ? error.response.data : error
    }
  }
}

export default new ClienteService()
