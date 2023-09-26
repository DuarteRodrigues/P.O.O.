## Programa do Servidor

import socket
import sqlite3

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

dbNome = "ProjetoPython.db"

global conn
conn = sqlite3.connect(dbNome)

ip = "127.0.0.1"
porto = 5000
s.bind((ip, porto ))
s.listen(5)

print("Este servidor permitirá enviar informação para a Base de dados do projeto de python")

c, addr = s.accept()
print("Ligação de", addr)

while True:  
    escolha = c.recv(1024)
    x = escolha.decode()
    choice = int(x)
    
    print ("A escolha é ", x)
    
    ##Ações das escolhas
    
    if choice == 1:
        nome_disc = c.recv(1024)
        disciplina = nome_disc.decode()
        
        print("Disciplina a inserir: ", disciplina)

        sql = """
        INSERT INTO Disciplinas(NOME_DISC, CODIGO_PROF, NOME_PROF)
        VALUES (?, ?, ?);
        """

        bd = conn.cursor()

        dados_disc = (disciplina, "", "")
        try:
            bd.execute(sql, dados_disc)
            conn.commit()
        except:
            print("O registo já existe")
            
        
    
    if choice == 4:
        num_a = c.recv(1024)
        y = num_a.decode()
        numero = int(y)
        numero_aluno = numero
        nom_a = c.recv(1024)
        nome_aluno = nom_a.decode()
        
        
        sql = """
        INSERT INTO Alunos(NUMERO_ALUNO, NOME_ALUNO)
        VALUES (?, ?);
        """
    
        bd = conn.cursor()
    
        dados_aluno = (numero_aluno, nome_aluno)
        
        try:
            bd.execute(sql, dados_aluno)
            conn.commit()
        except:
            print("O registo já existe")
            
    elif choice == 9:
        num_p = c.recv(1024)
        y = num_p.decode()
        numero = int(y)
        numero_prof = numero
        nom_p = c.recv(1024)
        nome_prof = nom_p.decode()
        
    
        sql = """
        INSERT INTO Professores(NUMERO_PROF, NOME)
        VALUES (?, ?);
        """
    
        bd = conn.cursor()
    
        dados_prof = (numero_prof, nome_prof)
       
        try:
            bd.execute(sql, dados_prof)
            conn.commit()
        except:
            print("O registo já existe")
        
    else:
        print("Nada vai ser acionado")
             

print("Acaba aqui") 
c.close()
         
s.close()
