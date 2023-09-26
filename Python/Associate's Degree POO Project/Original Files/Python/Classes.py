## Programa das Classes

class Utente():
    nome = ""
    idade = 0
    morada = ""
    

class Aluno(Utente):
    numero_aluno = 0 ## são 8 dígitos
    cc = 0
    
    def __init__ (self, numero_aluno, nome, idade, morada, cc):
        self.numero_aluno = numero_aluno
        self.nome = nome
        self.idade = idade
        self.morada = morada
        self.cc = cc
        pass
    
    def mostrarNumeroAluno(self):
        return self.numero_aluno 
        pass
    
    def mostrarNomeAluno(self):
        return self.nome 
        pass
    
class Professor(Utente):
    numero_prof = 0 ## são 5 dígitos
    categoria_prof = ""
    anos_exp = 0
    
    def __init__ (self, numero_prof, nome, idade, morada, categoria_prof, anos_exp):
        self.numero_prof = numero_prof
        self.nome = nome
        self.idade = idade
        self.morada = morada
        self.categoria_prof = categoria_prof
        self.anos_exp = anos_exp
        pass
    
    def mostrarNumeroProf(self):
        return self.numero_prof 
        pass
    
    def mostrarNomeProf(self):
        return self.nome 
        pass
    
class Disciplina():
    numero_aluno = 0
    nome_aluno = list()
    nome_disc = ""
    nome_prof = ""
    numero_prof = 0

    def __init__ (self,  nome_disc, nome_prof, numero_prof):
        self.nome_disc = nome_disc
        self.nome_prof = nome_prof
        self.numero_prof = numero_prof
        self.nome_aluno = list()
        pass
    
    def mostrarNomeDisc(self):
        return(self.nome_disc)
        pass
    
    def RegistarProf(self, nome_disc, nome_prof, numero_prof):
        self.nome_disc = nome_disc
        self.nome_prof = nome_prof
        self.numero_prof = numero_prof
        pass

    def InscreverAluno(self, aluno):
         self.nome_aluno.append(aluno)
         pass
     
    def mostrarInscFiltrada(self):
        for aluno in self.nome_aluno:
            print("|", aluno.mostrarNumeroAluno(),
                  "|", aluno.mostrarNomeAluno(),
                  "|", aluno.mostrarNomeDisc(),
                  "|", aluno.mostrarNomeProf(), 
                  "|", aluno.mostrarNumeroProf(),
                  "|")
        pass
            