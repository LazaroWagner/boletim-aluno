-- TURMA
INSERT INTO turma (id, nome) VALUES (1, '1º Ano A');
INSERT INTO turma (id, nome) VALUES (2, '2º Ano B');

-- DISCIPLINA
INSERT INTO disciplina (id, nome) VALUES (1, 'Matemática');
INSERT INTO disciplina (id, nome) VALUES (2, 'Português');

-- ALUNO
INSERT INTO aluno (id, nome, turma_id) VALUES (1, 'Ana Clara', 1);
INSERT INTO aluno (id, nome, turma_id) VALUES (2, 'Bruno Silva', 1);
INSERT INTO aluno (id, nome, turma_id) VALUES (3, 'Carlos Eduardo', 2);

-- AVALIAÇAO
INSERT INTO avaliacao (id, tipo, data, peso, disciplina_id) VALUES (1, 'Prova 1', '2025-10-10', 3, 1);
INSERT INTO avaliacao (id, tipo, data, peso, disciplina_id) VALUES (2, 'Trabalho', '2025-10-20', 2, 1);
INSERT INTO avaliacao (id, tipo, data, peso, disciplina_id) VALUES (3, 'Prova 1', '2025-10-15', 3, 2);
INSERT INTO avaliacao (id, tipo, data, peso, disciplina_id) VALUES (4, 'Seminário', '2025-10-25', 1, 2);

-- NOTA
INSERT INTO nota (id, valor, aluno_id, avaliacao_id, turma_id) VALUES (1, 8.5, 1, 1, 1);
INSERT INTO nota (id, valor, aluno_id, avaliacao_id, turma_id) VALUES (2, 7.0, 2, 1, 1);
INSERT INTO nota (id, valor, aluno_id, avaliacao_id, turma_id) VALUES (3, 9.0, 1, 2, 1);
INSERT INTO nota (id, valor, aluno_id, avaliacao_id, turma_id) VALUES (4, 6.5, 2, 2, 1);
INSERT INTO nota (id, valor, aluno_id, avaliacao_id, turma_id) VALUES (5, 8.0, 3, 3, 2);
INSERT INTO nota (id, valor, aluno_id, avaliacao_id, turma_id) VALUES (6, 7.5, 3, 4, 2);