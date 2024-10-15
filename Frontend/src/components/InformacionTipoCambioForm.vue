<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="12" md="10">
        <v-card class="elevation-12">
          <v-card-title class="title text-center">Consultar Tipo de Cambio</v-card-title>
          <v-card-text>
            <v-row>
              <v-col cols="12" md="6" class="text-center">
                <v-btn color="green" @click="consultarTipoCambioCompra">
                  Consultar Tipo de Cambio de Compra
                </v-btn>
                <v-alert v-if="tipoCambioCompra" type="success" dismissible>
                  Tipo de Cambio de Compra: ₡{{ tipoCambioCompra }}
                </v-alert>
                <v-alert v-if="errorCompra" type="error" dismissible>
                  Error: {{ errorCompra }}
                </v-alert>
              </v-col>

              <v-col cols="12" md="6" class="text-center">
                <v-btn color="red" @click="consultarTipoCambioVenta">
                  Consultar Tipo de Cambio de Venta
                </v-btn>
                <v-alert v-if="tipoCambioVenta" type="success" dismissible>
                  Tipo de Cambio de Venta: ₡{{ tipoCambioVenta }}
                </v-alert>
                <v-alert v-if="errorVenta" type="error" dismissible>
                  Error: {{ errorVenta }}
                </v-alert>
              </v-col>
            </v-row>

            <v-row justify="center">
              <v-col cols="4" class="text-center">
                <BotonSalir />
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import BotonSalir from '@/components/Botones/BotonSalir.vue'

const tipoCambioCompra = ref(null)
const tipoCambioVenta = ref(null)
const errorCompra = ref(null)
const errorVenta = ref(null)

const consultarTipoCambioCompra = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/tipo-cambio/compra')
    tipoCambioCompra.value = response.data
    errorCompra.value = null
  } catch (error) {
    console.error(error)
    errorCompra.value = 'Error al obtener tipo de cambio de compra'
    tipoCambioCompra.value = null
  }
}

const consultarTipoCambioVenta = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/tipo-cambio/venta')
    tipoCambioVenta.value = response.data
    errorVenta.value = null
  } catch (error) {
    console.error(error)
    errorVenta.value = 'Error al obtener tipo de cambio de venta'
    tipoCambioVenta.value = null
  }
}
</script>

<style scoped>
.v-container {
  background: linear-gradient(to bottom right, #b9ece8, #43e4a1);
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
}

.v-card {
  margin: 20px;
  background-color: #f9f9f9;
  border-radius: 12px;
}

.title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #2c3e50;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
}

.v-row {
  margin-bottom: 20px;
}

.text-center {
  text-align: center;
}

.v-btn {
  margin: 10px 0;
}
</style>
