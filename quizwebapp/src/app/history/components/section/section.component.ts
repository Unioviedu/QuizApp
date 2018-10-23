import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SectionsService } from '../../services/sections.service';

import { Section } from '../../model/section.model';
import { Level } from '../../model/level.model';
import { InfoUser } from 'src/app/shared/model/info-user.model';

declare var jQuery: any;

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
})
export class SectionComponent implements OnInit {
  @ViewChild('myModal') myModal;

  codSection: string;
  section: Section = new Section();
  levelsMain: Level[];
  levelsOptional: Level[];

  newInfo: InfoUser = new InfoUser(undefined);

  constructor(private activatedRoute: ActivatedRoute,
    private sectionsService: SectionsService) {
    this.activatedRoute.params.subscribe(params => {
      this.codSection = params['cod'];
    });
  }

  ngOnInit() {
    this.loadLevels();

    const newInfo = this.sectionsService.newInfo;

    if (newInfo) {
      this.newInfo = new InfoUser(newInfo);

      jQuery(this.myModal.nativeElement).modal('show');
      this.sectionsService.changeInfo(null);
    }
  }

  loadLevels() {
    this.sectionsService.getSection(this.codSection)
      .subscribe(data => {
        this.section = data;
        this.levelsMain = data.levels.filter(level => level.main).sort((a, b) => a.name.localeCompare(b.name));
        this.levelsOptional = data.levels.filter(level => !level.main).sort((a, b) => a.name.localeCompare(b.name));
      }
      );
  }

  getChallangeDescription(i: number) {
    return this.section.challanges[i].challange.description;
  }

  getClass(i: number) {
    const base = 'list-group-item';

    return this.section.challanges[i].complete ?
      base + ' list-group-item-success' :
      base;
  }

}
