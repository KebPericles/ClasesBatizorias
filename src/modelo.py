#!/usr/bin/env python
# coding: utf-8

# In[2]:


import math
import numpy as np
import pandas as pd
import seaborn as sb
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
from matplotlib import cm
plt.rcParams['figure.figsize'] = (16, 9)
plt.style.use('ggplot')
from sklearn import linear_model
from sklearn.metrics import mean_squared_error, r2_score

data=pd.read_csv("Chidas.csv")
dataX=pd.DataFrame()


# In[10]:


i = 0

materias = ('probabilidad y estadistica','calculo integral','calculo diferencial','geometria analitica','geometria y trigonometria','algebra','algebra')
preguntas = ('¿Que tanta atencion crees que ponias en las clases?','¿Cuantas horas de estudio le dedicabas por semana antes de una evaluacion importante?','¿Cuantas horas de estudio le dedicabas por semana?','¿Que tanto crees que le entendias a la clase?','¿Que tan dificil era para ti la materia en general?','¿Cuantas horas de asesorias o cursos tomaste hasta pasar la materia?','¿Con cuantas tareas cumplias en el semestre?')
variables = ('atencion','horasEstudioExamen','horasEstudioSemana','entendimiento','dificultad','asesorias','tareas')

dataX = pd.DataFrame()
dataXL = []
ytrainP = []
materiasPreguntas = []

for materia in materias:
    preguntasChecadas = []
    if i < 6:
        calificacionesR = data['¿Que calificacion sacaste en '+materia+'?']
        
        for calificacionR in calificacionesR:
            if not math.isnan(calificacionR):
                ytrainP.append(calificacionR)

        
        j = 0
        for pregunta in preguntas:
            if i == 0:
                datosPreguntaMateria = pd.DataFrame()
                datosPreguntaMateria[variables[j]]=data[pregunta].values
                datosChecados = []

                for dato in datosPreguntaMateria[variables[j]]:
                    if not math.isnan(dato):
                        datosChecados.append(dato)

                preguntasChecadas.append(datosChecados)
            elif i > 0:
                datosPreguntaMateria = pd.DataFrame()
                datosPreguntaMateria[variables[j]]=data[pregunta+'.'+str(i)].values
                datosChecados = []

                for dato in datosPreguntaMateria[variables[j]]:
                    if not math.isnan(dato):
                        datosChecados.append(dato)

                preguntasChecadas.append(datosChecados)
            j += 1
        materiasPreguntas.append(preguntasChecadas)
    i+=1

for materiaPreguntas in materiasPreguntas:
    for i in range(len(materiaPreguntas[0])):
        registro = []
        registro.append(materiaPreguntas[0][i])
        registro.append(materiaPreguntas[1][i])
        registro.append(materiaPreguntas[2][i])
        registro.append(materiaPreguntas[3][i])
        registro.append(materiaPreguntas[4][i])
        registro.append(materiaPreguntas[5][i])
        registro.append(materiaPreguntas[6][i])
        dataXL.append(registro)

dataX = pd.DataFrame(dataXL)

xmultrain=np.array(dataX)
ytrain=np.array(ytrainP)

# Creamos el objeto de Regresión Linear
regr = linear_model.LinearRegression()

# Entrenamos nuestro modelo
regr.fit(xmultrain, ytrain)

# Hacemos las predicciones que en definitiva una línea (en este caso, al ser 2D)
y_pred = regr.predict(xmultrain)

print('\noriginal: \n'+ str(ytrain))
print('\nprediccion: \n'+ str(y_pred)) 

# Veamos los coeficienetes obtenidos, En nuestro caso, serán la Tangente
print('\nCoefficients: \n', regr.coef_)

# Este es el valor donde corta el eje Y (en X=0)
print('\nIndependent term: \n', regr.intercept_)

# Error Cuadrado Medio
print("\nMean squared error: %.2f" % mean_squared_error(ytrain, y_pred))

#Puntaje de Varianza. El mejor puntaje es un 1.0
print('\nVariance score: %.2f' % r2_score(ytrain, y_pred))

archivo = open("coeficientesModelo",'w')

for i in regr.coef_:
    archivo.write(str(i)+'\n')

archivo = open("coeficientesModelo",'r')
print(archivo.read())

