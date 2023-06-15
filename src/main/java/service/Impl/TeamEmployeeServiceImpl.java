package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.TeamEmployee;
import repository.TeamEmployeeRepository;
import service.TeamEmployeeService;

public class TeamEmployeeServiceImpl extends BaseServiceImpl<TeamEmployee, Long, TeamEmployeeRepository>
implements TeamEmployeeService {

    public TeamEmployeeServiceImpl(TeamEmployeeRepository repository) {
        super(repository);
    }

}
