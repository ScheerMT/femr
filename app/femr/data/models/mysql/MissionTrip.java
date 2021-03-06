/*
     fEMR - fast Electronic Medical Records
     Copyright (C) 2014  Team fEMR

     fEMR is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.

     fEMR is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with fEMR.  If not, see <http://www.gnu.org/licenses/>. If
     you have any questions, contact <info@teamfemr.org>.
*/
package femr.data.models.mysql;

import femr.data.models.core.IMissionCity;
import femr.data.models.core.IMissionTeam;
import femr.data.models.core.IMissionTrip;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mission_trips")
public class MissionTrip implements IMissionTrip {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mission_team_id")
    private MissionTeam missionTeam;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mission_city_id")
    private MissionCity missionCity;
    @Column(name = "isCurrent", nullable = false)
    private boolean isCurrent;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public IMissionTeam getMissionTeam() {
        return missionTeam;
    }

    @Override
    public void setMissionTeam(IMissionTeam missionTeam) {
        this.missionTeam = (MissionTeam) missionTeam;
    }

    @Override
    public IMissionCity getMissionCity() {
        return missionCity;
    }

    @Override
    public void setMissionCity(IMissionCity missionCity) {
        this.missionCity = (MissionCity) missionCity;
    }

    @Override
    public boolean isCurrent() {
        return isCurrent;
    }

    @Override
    public void setCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
