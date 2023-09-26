## Programa Principal

import Modulos
import socket
import os

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

ip = "127.0.0.1"
porto = 5000

s.connect((ip, porto))

lista_alunos = list()
lista_professores = list()
lista_disciplinas = list()

escolha = 50

##-------------------Parâmetros do Programa Main-------------------##



while escolha != 0:
    Modulos.menu()
    escolha = int(input("Insira o número correspondente à sua escolha: "))
    s.send(str(escolha).encode('utf8'))

    if escolha == 1:
        print("Criar Disciplina")
        Modulos.adicionarDisciplinas(s, lista_disciplinas)
        
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
        ##fim da tarefa 1 - Criar Disciplina - Funciona
            
    elif escolha == 2:
        print("Listar Disciplina")
        Modulos.listarDisciplinas(lista_disciplinas)
        
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
            
        ##fim da tarefa 2 - Listar Disciplinas - Funciona
        
            
    elif escolha == 3:
        print("Eliminar Disciplina")
        Modulos.eliminarDisciplinas(lista_disciplinas)
        
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
        
        ##fim da tarefa 3 - Eliminar Disciplina    
            
    elif escolha == 4:
        print("Criar Aluno")
        Modulos.adicionarAluno(s, lista_alunos)
        
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
    
        ##fim da tarefa 4 - Criar Aluno
    
    elif escolha == 5:
        print("Inscrever Aluno")
        Modulos.inscreverAluno(lista_alunos, lista_disciplinas, s)
            
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
             
        ##fim da tarefa 5 - Inscrever Aluno
            
    elif (escolha == 6):
        os.system("cls")
        print("Eliminar Alunos")
        Modulos.eliminarAlunos(lista_alunos)
    
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
            
         ##fim da tarefa 6 - Eliminar Aluno
        
    elif (escolha == 7):
        print("Listar Aluno")
        Modulos.listarAlunos(lista_alunos)
        
        
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
        
         ##fim da tarefa 7 - Listar Alunos
    
    elif (escolha == 8):
        print("Listar Alunos Inscritos Numa Disciplina")
        Modulos.listarAlunosdeDisciplinas(lista_disciplinas)
    
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
            
         ##fim da tarefa 8 - Listar Alunos Inscritos Numa Disciplina 
    
    elif (escolha == 9):
        print("Criar Professor")
        Modulos.adicionarProf(s, lista_professores)
        
        
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
            
        ##fim da tarefa 9 - Criar Professor
    
    elif (escolha == 10):
        print("Adicionar Professor a Disciplina")
        Modulos.adProfADisciplina(lista_disciplinas, lista_professores)
    
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
    
         ##fim da tarefa 10 - Adicionar Professor à Disciplina
    
    elif (escolha == 11):
        print("Importar Alunos de um Ficheiro")
        Modulos.lerFicheiro(lista_alunos)
        
        volta = 50
        volta = int (input("Pretende voltar ao menu?(1-Sim / 0-Não):"))
        
        if(volta==0):
            os.system("cls")
            print("Obrigado por utilizar a plataforma")
        elif(volta==1):
            os.system("cls")
            print("")
            
        else:
            print("Valor inválido")
            volta = int (input("Pretende voltar ao menu?(1-Sim/0-Não):"))
    
        ##fim da tarefa 11 - Importar Alunos de um Ficheiro
    
    elif (escolha == 0):
        print("Sair")
        os.system("cls")
        print("Obrigado por utilizar a plataforma")
    
         ##fim da tarefa 0 - Sair
    else:
        print("Valor inválido")
        Modulos.menu()
        escolha = int(input("Insira o número correspondente à sua escolha: "))        
