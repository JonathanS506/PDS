// src/services/TransaccionService.js
import axios from '../axios'

export default {
  agregarTransaccion(transaccion, numeroCuenta, codigoCliente) {
    return axios.post('/transacciones', transaccion, {
      params: { numeroCuenta, codigoCliente }
    })
  },
  obtenerTransacciones(numeroCuenta, codigoCliente) {
    return axios.get(`/transacciones/${numeroCuenta}/${codigoCliente}`)
  },
  contarTransacciones(numeroCuenta, idCliente) {
    return axios.get(`/transacciones/count/${numeroCuenta}/${idCliente}`)
  }
}
