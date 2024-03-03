.data
msg1: 	.asciiz "Ingrese una calificaci�n: "
msg2: 	.asciiz "�Desea actualizar el valor? (1/0): "
ans: 	.asciiz "La calificaci�n actual es: "
msg3: 	.asciiz "�Desea restaurar el valor anterior? (1/0): "

.align 2
memento: 	 .space 4 #MEMENTO: Valor original de la calificaci�n
originator: 	 .space 4 #ORIGINATOR:  Valor actual de la calificaci�n

.text
.globl main

main:
    # Pide al usuario que ingrese una calificaci�n
    li $v0 4
    la $a0 msg1
    syscall
    # Lee la calificaci�n y la guarda en memento y originator
    li $v0 5
    syscall
    move $t0 $v0
    sw $t0 memento
    sw $t0 originator
    
update: #CARETAKER
    # Pregunta al usuario si desea actualizar el valor
    li $v0 4
    la $a0 msg2
    syscall
    # Lee la respuesta del usuario
    li $v0 5
    syscall
    move $t1 $v0
    # Si el usuario desea actualizar el valor
    beq $t1 0 nUpdate
    # Pide al usuario que ingrese un nuevo valor
    li $v0 4
    la $a0 msg1
    syscall
    # Lee la nueva calificaci�n y la guarda en originator
    li $v0 5
    syscall
    move $t0 $v0
    sw $t0 originator
    # Muestra la calificaci�n actual
    li $v0 4
    la $a0 ans
    syscall
    #JUMP
    lw $a0 originator
    li $v0 1
    syscall
restore:
    # Pregunta al usuario si desea restaurar el valor original
    li $v0 4
    la $a0 msg3
    syscall
    # Lee la respuesta del usuario
    li $v0 5
    syscall
    move $t2 $v0
    beq $t2 0 nUpdate
    # Si el usuario desea restaurar el valor original
    # Muestra la calificaci�n original
    li $v0 4
    la $a0 ans
    syscall
    lw $a0 memento
    li $v0 1
    syscall
    j exit
nUpdate:
    li $v0 4
    la $a0 ans
    syscall
    lw $a0 originator
    li $v0 1
    syscall
exit:
    # Salida del programa
    li $v0 10
    syscall
