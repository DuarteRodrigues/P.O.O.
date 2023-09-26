## Programa Com MÃ³dulos
import Classes
import pandas
from random import randint


def menu():
    print("")
    print("##############################################")
    print("# Bem-Vindo/a                                #")
    print("##############################################")
    print("# 1) Criar Disciplina                        #")
    print("# 2) Listar Disciplina                       #")
    print("# 3) Eliminar Disciplina                     #")
    print("# 4) Criar Aluno                             #")
    print("# 5) Inscrever Aluno                         #")
    print("# 6) Eliminar Aluno                          #")
    print("# 7) Listar Alunos                           #")
    print("# 8) Listar Alunos Inscritos Numa Disciplina #")
    print("# 9) Criar Professor                         #")
    print("# 10) Adicionar Professor a Disciplina       #")
    print("# 11) Importar Alunos de um Ficheiro         #")
    print("##############################################")
    print("# 0) Sair                                    #")
    print("##############################################")
    pass

## 1 - Criar Disciplina - Funciona

def adicionarDisciplinas(s, lista_disciplinas):
    nomeDisciplina = input("Indique o Nome da Diciplina:")
    s.send(nomeDisciplina.encode())
    nomeProf = ""
    numeroProf = ""
    
    nova_disc = Classes.Disciplina(nomeDisciplina, nomeProf, numeroProf)
    lista_disciplinas.append(nova_disc)
    
    print("Disciplina Registada!")
    pass

## 2 - Listar disciplinas - Funciona

def listarDisciplinas(lista_disciplinas):
    print("Lista de disciplinas registadas: \n")
    contador = 1
    for disciplinas in lista_disciplinas:
        print(contador, " - ", disciplinas.mostrarNomeDisc())
        contador = contador + 1
    pass

## 3 - Eliminar Disciplina - Funciona

def eliminarDisciplinas(lista_disciplinas):
    listarDisciplinas(lista_disciplinas)
    ind = int (input("Indique a posicao da disciplina que deseja eliminar: "))
    ind = ind - 1
    try:
        lista_disciplinas.pop(ind)
    except:
        print("Ocorreu um erro.")
        
    listarDisciplinas(lista_disciplinas)
    pass

## 4 - Criar Aluno -.Funciona

def adicionarAluno(s, lista_alunos):
    numero_aluno = randint(22000000, 22009999)
    s.send(str(numero_aluno).encode('utf8'))
    nome_aluno = input("Insira o nome do/a aluno/a: ")
    s.send(nome_aluno.encode())
    idade_aluno = int(input("Insira a idade do/a aluno/a: "))
    morada_aluno = input("Insira a morada do/a aluno/a: ")
    cc_aluno = int(input("Insira o numero do CC do/a aluno/a: "))
    
    novo_aluno = Classes.Aluno(numero_aluno,
                               nome_aluno,
                               idade_aluno,
                               morada_aluno,
                               cc_aluno)
    lista_alunos.append(novo_aluno)
    pass

## 5 - Inscrever Aluno - 

def inscreverAluno(lista_alunos, lista_disciplinas, s):
    listarAlunos(lista_alunos)
    indaln = int(input("Insira o índice do aluno que pretende inscrever:"))
    indaln = indaln - 1
    listarDisciplinas(lista_disciplinas)
    inddisc = int(input("Insira o indice da disciplina em que pretende inscrever o aluno"))
    inddisc = inddisc - 1
    
    aluno = lista_alunos[indaln]
    lista_disciplinas[inddisc].InscreverAluno(aluno)
    
    pass

## 6 - Eliminar Alunos - Funciona

def eliminarAlunos(lista_alunos):
    listarAlunos(lista_alunos)
    ind = int (input("Indique a posicao do/a aluno/a que deseja eliminar: "))
    ind = ind - 1
    try:
       lista_alunos.pop(ind)
        
    except:
        print("Ocorreu um erro.")
        
    listarAlunos(lista_alunos)
    pass

## 7 - Listar Alunos - Funciona

def listarAlunos(lista_alunos):
    print("Lista de alunos/as registados/as: \n")
    contador = 1
    for alunos in lista_alunos:
        print(contador, " - ", 
              alunos.mostrarNumeroAluno(), "-",
              alunos.mostrarNomeAluno())
        contador = contador + 1
    pass

## 8 - Listar Alunos de uma Disciplina Específica

def listarAlunosdeDisciplinas(lista_disciplinas):
    listarDisciplinas(lista_disciplinas)
    inddisc = int(input("Insira o indice da disciplina em que pretende ver os inscritos"))
    inddisc = inddisc - 1
    
    lista_disciplinas[inddisc].mostrarInscFiltrada()
    pass
    
## 9 - Criar Professores - Funciona

def adicionarProf(s, lista_profs):    
    numero_prof = randint(60000, 65000)
    s.send(str(numero_prof).encode('utf8'))
    nome_prof = input("Insira o nome do/a professor/a: ")
    s.send(nome_prof.encode())
    idade_prof = int(input("Insira a idade do/a professor/a: "))
    morada_prof = input("Insira a morada do/a professor/a: ")
    categoria_prof = input("Insira a categoria do/a professor/a: ")
    anos_exp = int(input("Insira os anos de experiencia do/a professor/a: "))
    
    novo_prof = Classes.Professor(numero_prof, 
                                  nome_prof,
                                  idade_prof, 
                                  morada_prof, 
                                  categoria_prof, 
                                  anos_exp)
    lista_profs.append(novo_prof)
    pass

## Necessidade - Listar Professores

def listarProfs(lista_profs):
    print("Lista de professores/as registados/as: \n")
    contador = 1
    for profs in lista_profs:
        print(contador," - ", 
              profs.mostrarNumeroProf() ,"-",
              profs.mostrarNomeProf())
        contador = contador + 1
    pass

## 10 - Adicionar Professor à Disciplina

def adProfADisciplina(lista_disciplinas, lista_professores):
    listarDisciplinas(lista_disciplinas)
    inddisc = int(input("Indique o numero da disciplina que quer inscrever o professor:"))
    inddisc = inddisc - 1
    listarProfs(lista_professores)
    indprof = int(input("Indique o numero do/a profesor/a para inscrever na disciplina selecionada:"))
    indprof = indprof - 1
    
    nome_disc = lista_disciplinas[inddisc].nome_disc
    nome_prof = lista_professores[indprof].nome
    num_prof = lista_professores[indprof].numero_prof
    
    lista_disciplinas[inddisc].RegistarProf(nome_disc, nome_prof, num_prof)
    print("Inscrito com sucesso")
    pass

## 11 - Importar Alunos de um Ficheiro

#def lerFicheiro(lista_alunos):
    #f = pandas.read_excel('ExcelProjeto.xlsx' , sheet_name='Folha1')

    #for i in f.index:
        #nome_aluno = f['nome_aluno'][i] 
        #idade_aluno= f['idade_aluno'][i] 
        #morada_aluno = f['morada_aluno'][i] 
        #cc_aluno =  f['cc_aluno'][i] 
        #numero_aluno = f['numero_aluno'][i]
        
        #novo_aluno = Classes.Aluno(numero_aluno,
                                   #nome_aluno,
                                   #idade_aluno,
                                   #morada_aluno,
                                   #cc_aluno)
        #lista_alunos.append(novo_aluno)
        #print("Ficheiro importado e registos registados em memória")        
        #pass
    #listarAlunos(lista_alunos)
    #pass 
