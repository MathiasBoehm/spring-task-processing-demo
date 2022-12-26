select count(*) from task;

select max(claimed - created) from task;

select distinct(status) from task;

delete from task;

commit;

select count(*) from task where status !=