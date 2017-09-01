.SECT .TEXT !1
MOV CX,num-vec !2
SHR CX,1 !3
MOV BX,vec !4
MOV SI,0 !5
MOV AX,(num) !6
1: CMP (BX)(SI),AX !7
JE 2f !8
ADD SI,2 !9
LOOP 1b !10
MOV DX,0 !11
JMP 3f !12
2: MOV DX,1 !13
3: PUSH 1
SYS
.SECT .DATA
vec: .WORD 3,4,7,11,3
num: .WORD 8
format: .ASCII "%"
