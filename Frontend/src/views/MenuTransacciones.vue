<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <h1 class="title title-background">Funcionalidades para las transacciones</h1>
      </v-col>
    </v-row>

    <v-row align="center" justify="center" class="button-row">
      <v-col cols="12" sm="4" class="text-center">
        <v-icon large color="black">mdi-cash-plus</v-icon>
        <BotonRealizarDepositoCols />
      </v-col>
      <v-col cols="12" sm="4" class="text-center">
        <v-icon large color="black">mdi-cash-plus</v-icon>
        <BotonRealizarDepositoDols />
      </v-col>
      <v-col cols="12" sm="4" class="text-center">
        <v-icon large color="black">mdi-cash-minus</v-icon>
        <BotonRealizarRetiroCols />
      </v-col>
    </v-row>

    <v-row align="center" justify="center" class="button-row">
      <v-col cols="12" sm="4" class="text-center">
        <v-icon large color="black">mdi-cash-minus</v-icon>
        <BotonRealizarRetiroDols />
      </v-col>
      <v-col cols="12" sm="4" class="text-center">
        <v-icon large color="black">mdi-transfer</v-icon>
        <BotonTransferencia />
      </v-col>
      <v-col cols="12" sm="4" class="text-center">
        <v-icon large color="black">mdi-file-document-outline</v-icon>
        <BotonTransaccionesHechas />
      </v-col>
    </v-row>

    <v-row align="center" justify="center" class="button-row">
      <v-col cols="12" sm="5" class="text-center">
        <v-icon large color="black">mdi-currency-eur</v-icon>
        <BotonConsultarSaldoCols />
      </v-col>
      <v-col cols="12" sm="5" class="text-center">
        <v-icon large color="black">mdi-currency-usd</v-icon>
        <BotonConsultarSaldoDols />
      </v-col>
    </v-row>

    <v-row align="center" justify="center" class="button-row">
      <v-col cols="12" sm="8" class="text-center">
        <v-icon large color="black">mdi-logout</v-icon>
        <BotonSalir />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import BotonRealizarDepositoCols from '@/components/Botones/BotonPagRealizarDepositoCols.vue'
import BotonRealizarDepositoDols from '@/components/Botones/BotonPagRealizarDepositoDols.vue'
import BotonConsultarSaldoCols from '@/components/Botones/BotonConsultarSaldoCols.vue'
import BotonConsultarSaldoDols from '@/components/Botones/BotonConsultarSaldoDols.vue'
import BotonRealizarRetiroCols from '@/components/Botones/BotonPagRealizarRetiroCols.vue'
import BotonRealizarRetiroDols from '@/components/Botones/BotonPagRealizarRetiroDols.vue'
import BotonTransaccionesHechas from '@/components/Botones/BotonTransaccionesHechas.vue'
import BotonSalir from '@/components/Botones/BotonSalir.vue'
import BotonTransferencia from '@/components/Botones/BotonPagTransferencia.vue'
</script>

<style scoped>
.fill-height {
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  background: linear-gradient(135deg, #c2cee0, #2867cc);
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
  max-width: 300px; /* Ajustar el ancho máximo según se necesite */
  font-size: 1.25rem;
  padding: 15px;
  white-space: normal;
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
  background-color: #1565c0;
}

.v-icon {
  margin-bottom: 10px;
  font-size: 3rem;
}
</style>
