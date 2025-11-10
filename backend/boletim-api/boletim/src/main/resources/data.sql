-- TURMA
INSERT INTO turma (nome) VALUES ('1º Ano A');
INSERT INTO turma (nome) VALUES ('2º Ano B');

-- DISCIPLINA
INSERT INTO disciplina (nome) VALUES ('Matemática');
INSERT INTO disciplina (nome) VALUES ('Português');

-- ALUNO
INSERT INTO aluno (nome, turma_id) VALUES ('Ana Clara', 1);
INSERT INTO aluno (nome, turma_id) VALUES ('Bruno Silva', 1);
INSERT INTO aluno (nome, turma_id) VALUES ('Carlos Eduardo', 2);

-- AVALIAÇAO
INSERT INTO avaliacao (tipo, data, peso, disciplina_id) VALUES ('Prova 1', '2025-10-10', 3, 1);
INSERT INTO avaliacao (tipo, data, peso, disciplina_id) VALUES ('Trabalho', '2025-10-20', 2, 1);
INSERT INTO avaliacao (tipo, data, peso, disciplina_id) VALUES ('Prova 1', '2025-10-15', 3, 2);
INSERT INTO avaliacao (tipo, data, peso, disciplina_id) VALUES ('Seminário', '2025-10-25', 1, 2);

-- NOTA
INSERT INTO nota (valor, aluno_id, avaliacao_id, turma_id) VALUES (8.5, 1, 1, 1);
INSERT INTO nota (valor, aluno_id, avaliacao_id, turma_id) VALUES (7.0, 2, 1, 1);
INSERT INTO nota (valor, aluno_id, avaliacao_id, turma_id) VALUES (9.0, 1, 2, 1);
INSERT INTO nota (valor, aluno_id, avaliacao_id, turma_id) VALUES (6.5, 2, 2, 1);
INSERT INTO nota (valor, aluno_id, avaliacao_id, turma_id) VALUES (8.0, 3, 3, 2);
INSERT INTO nota (valor, aluno_id, avaliacao_id, turma_id) VALUES (7.5, 3, 4, 2);