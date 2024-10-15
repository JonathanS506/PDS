import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/PaginaPrincipal.vue'
import CrearClienteFisico from '../views/CrearClienteFisico.vue'
import CrearClienteJuridico from '@/views/CrearClienteJuridico.vue'
import CrearCuenta from '@/views/CrearCuenta.vue'
import CambiarPin from '@/views/CambiarPin.vue'
import RealizarDepositoColones from '@/views/RealizarDepositoColones.vue'
import RealizarDepositoDolares from '@/views/RealizarDepositoDolares.vue'
import RealizarRetiroColones from '@/views/RealizarRetiroColones.vue'
import RealizarRetiroDolares from '@/views/RealizarRetiroDolares.vue'
import ConsultarTransacciones from '@/views/ConsultarTransacciones.vue'
import InformacionTipoCambio from '@/views/InformacionTipoCambio.vue'
import ConsultaSaldoActualColones from '@/views/ConsultaSaldoActualColones.vue'
import ConsultaSaldoActualDolares from '@/views/ConsultaSaldoActualDolares.vue'
import EstadoCuentaColones from '@/views/EstadoCuentaColones.vue'
import EstadoCuentaDolares from '@/views/EstadoCuentaDolares.vue'
import CambiarTelefono from '@/views/CambiarTelefono.vue'
import CambiarCorreo from '@/views/CambiarCorreo.vue'
import ConsultarEstatus from '@/views/ConsultarEstatus.vue'
import ConsultaCTESaldo from '@/views/ConsultaCTESaldo.vue'
import EliminarCuenta from '@/views/EliminarCuenta.vue'
import MenuClientes from '@/views/MenuClientes.vue'
import MenuCuentas from '@/views/MenuCuentas.vue'
import MenuTransacciones from '@/views/MenuTransacciones.vue'
import RealizarTransferencia from '@/views/RealizarTransferencia.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/crear-cliente-fisico',
    name: 'CrearClienteFisico',
    component: CrearClienteFisico
  },
  {
    path: '/crear-cliente-juridico',
    name: 'CrearClienteJuridico',
    component: CrearClienteJuridico
  },
  {
    path: '/crear-cuenta',
    name: 'CrearCuenta',
    component: CrearCuenta
  },
  {
    path: '/cambiar-pin',
    name: 'CambiarPin',
    component: CambiarPin
  },
  {
    path: '/realizar-deposito-colones',
    name: 'RealizarDepositoColones',
    component: RealizarDepositoColones
  },
  {
    path: '/realizar-deposito-dolares',
    name: 'RealizarDepositoDolares',
    component: RealizarDepositoDolares
  },
  {
    path: '/realizar-retiro-colones',
    name: 'RealizarRetiroColones',
    component: RealizarRetiroColones
  },
  {
    path: '/realizar-retiro-dolares',
    name: 'RealizarRetiroDolares',
    component: RealizarRetiroDolares
  },
  {
    path: '/consultar-transacciones',
    name: 'ConsultarTransacciones',
    component: ConsultarTransacciones
  },
  {
    path: '/informacion-tipo-de-cambio',
    name: 'InformacionTipoCambio',
    component: InformacionTipoCambio
  },
  {
    path: '/consulta-saldo-colones',
    name: 'ConsultaSaldoActualColones',
    component: ConsultaSaldoActualColones
  },
  {
    path: '/consulta-saldo-dolares',
    name: 'ConsultaSaldoActualDolares',
    component: ConsultaSaldoActualDolares
  },
  {
    path: '/estado-cuenta-colones',
    name: 'EstadoCuentaColones',
    component: EstadoCuentaColones
  },
  {
    path: '/estado-cuenta-dolares',
    name: 'EstadoCuentaDolares',
    component: EstadoCuentaDolares
  },
  {
    path: '/cambiar-telefono',
    name: 'CambiarTelefono',
    component: CambiarTelefono
  },
  {
    path: '/cambiar-correo',
    name: 'CambiarCorreo',
    component: CambiarCorreo
  },
  {
    path: '/consultar-estatus',
    name: 'ConsultarEstatus',
    component: ConsultarEstatus
  },
  {
    path: '/consultar-cte-saldo', //RQ 20 - No se como ponerle jeje
    name: 'ConsultaCTESaldo',
    component: ConsultaCTESaldo
  },
  {
    path: '/eliminar-cuenta',
    name: 'EliminarCuenta',
    component: EliminarCuenta
  },
  {
    path: '/menu-clientes',
    name: 'MenuClientes',
    component: MenuClientes
  },
  {
    path: '/menu-transacciones',
    name: 'MenuTransacciones',
    component: MenuTransacciones
  },
  {
    path: '/menu-cuentas',
    name: 'MenuCuentas',
    component: MenuCuentas
  },
  {
    path: '/realizar-transferencia',
    name: 'RealizarTransferencia',
    component: RealizarTransferencia
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
