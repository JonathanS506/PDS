<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="space-between">
      <v-col cols="auto">
        <img src="@/assets/LogoTec.png" alt="Logo Tecnológico de Costa Rica" class="logo-left" />
      </v-col>
      <v-col cols="auto">
        <h1 class="title title-background">Bienvenido a la página de CAC-TEC</h1>
      </v-col>
      <v-col cols="auto">
        <img src="@/assets/LogoATI.png" alt="Logo ATI" class="logo-right" />
      </v-col>
    </v-row>

    <v-row align="center" justify="center" class="button-row">
      <v-col cols="12" sm="4">
        <v-icon large>mdi-bank</v-icon>
        <BotonCliente />
      </v-col>
      <v-col cols="12" sm="4">
        <v-icon large>mdi-account</v-icon>
        <BotonCuenta />
      </v-col>
      <v-col cols="12" sm="4">
        <v-icon large>mdi-transfer</v-icon>
        <BotonTransacciones />
      </v-col>
    </v-row>

    <v-row align="center" justify="center" class="button-row">
      <v-col cols="12" sm="6">
        <v-icon large>mdi-currency-usd</v-icon>
        <BotonTipoCambio />
      </v-col>
      <v-col cols="12" sm="6">
        <v-icon large>mdi-file-document</v-icon>
        <BotonEstatus />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import BotonCliente from '@/components/Botones/BotonCliente.vue' // Importar el botón de Cliente
import BotonCuenta from '@/components/Botones/BotonPagCuenta.vue' // Importar el botón de Cuentas
import BotonTransacciones from '@/components/Botones/BotonPagTransacciones.vue' // Importar el botón de Transacciones
import BotonTipoCambio from '@/components/Botones/BotonTipoCambio.vue' // Importar el botón de Tipo de Cambio
import BotonEstatus from '@/components/Botones/BotonEstatus.vue' 
</script>

<style scoped>
.fill-height {
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  background: linear-gradient(135deg, #c2cee0, #2867cc); /* Fondo uniforme */
}

.logo-left {
  width: 300px;
  position: absolute;
  top: 10px;
  left: 10px;
}

.logo-right {
  width: 300px;
  position: absolute;
  top: 10px;
  right: 10px;
}

.title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #2c3e50;
  margin-bottom: 40px;
}

.title-background {
  background-color: #74b2e7;
  padding: 10px;
  border-radius: 5px;
}

.button-row {
  margin-bottom: 40px;
}

.v-btn {
  width: 100%;
  max-width: 300px;
  font-size: 1.5rem;
  padding: 30px;
}

.custom-btn {
  color: #2c3e50;
  transition:
    transform 0.3s,
    background-color 0.3s;
}

.custom-btn:hover {
  transform: scale(1.05);
  background-color: #1e88e5;
}

.custom-btn:active {
  transform: scale(0.95);
  background-color: #0c325e;
}

.v-icon {
  margin-bottom: 10px;
  color: #000;
  font-size: 4rem;
}
</style>


